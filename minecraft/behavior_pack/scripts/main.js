import { world, system, Player, BlockPermutation } from "@minecraft/server";
import { ActionFormData, MessageFormData } from "@minecraft/server-ui";

// ROXY CLIENT Main Script
// Version: 1.0.0
// Supports Bedrock 1.20.0+

const ROXY_CLIENT_VERSION = "1.0.0";
const ROXY_PREFIX = "§l§5[ROXY]§r ";

// Initialize client
world.beforeEvents.worldInitialize.subscribe((event) => {
    console.warn(`${ROXY_PREFIX}ROXY CLIENT ${ROXY_CLIENT_VERSION} initialized`);
});

// Player tracking system
class PlayerTracker {
    constructor() {
        this.players = new Map();
    }

    addPlayer(player) {
        if (!this.players.has(player.id)) {
            this.players.set(player.id, {
                name: player.name,
                location: player.location,
                dimension: player.dimension.id,
                health: player.getComponent("minecraft:health").currentValue,
                joined: Date.now()
            });
        }
    }

    updatePlayer(player) {
        if (this.players.has(player.id)) {
            const playerData = this.players.get(player.id);
            playerData.location = player.location;
            playerData.health = player.getComponent("minecraft:health").currentValue;
        }
    }

    removePlayer(playerId) {
        this.players.delete(playerId);
    }

    getPlayerData(player) {
        return this.players.get(player.id);
    }

    getAllPlayers() {
        return Array.from(this.players.values());
    }
}

const tracker = new PlayerTracker();

// Track player joins/leaves
world.afterEvents.playerSpawn.subscribe((event) => {
    const player = event.player;
    tracker.addPlayer(player);
    player.sendMessage(`${ROXY_PREFIX}Welcome! ROXY CLIENT loaded. Use /roxy help for commands.`);
});

world.afterEvents.playerLeave.subscribe((event) => {
    tracker.removePlayer(event.playerId);
});

// Command handler
world.afterEvents.chatSend.subscribe((event) => {
    const player = event.sender;
    const message = event.message.trim();

    if (message.startsWith("/roxy")) {
        handleRoxyCommand(player, message);
        event.cancel = true;
    }
});

function handleRoxyCommand(player, command) {
    const args = command.split(" ");
    const subcommand = args[1]?.toLowerCase() || "help";

    switch (subcommand) {
        case "help":
            showHelpMenu(player);
            break;
        case "coords":
            showCoordinates(player);
            break;
        case "players":
            showPlayerList(player);
            break;
        case "status":
            showStatus(player);
            break;
        case "biome":
            showBiomeInfo(player);
            break;
        default:
            player.sendMessage(`${ROXY_PREFIX}Unknown command. Use /roxy help`);
    }
}

function showHelpMenu(player) {
    const helpText = `
§l§5ROXY CLIENT v${ROXY_CLIENT_VERSION}§r

§bAvailable Commands:§r
/roxy help - Show this help
/roxy coords - Show coordinates
/roxy players - Show nearby players
/roxy status - Show player status
/roxy biome - Show current biome
    `;
    player.sendMessage(helpText);
}

function showCoordinates(player) {
    const loc = player.location;
    const heading = player.getRotation().y;
    const direction = getDirection(heading);
    
    const coordText = `
§l§5Coordinates§r
§6X: §f${Math.floor(loc.x)}
§6Y: §f${Math.floor(loc.y)}
§6Z: §f${Math.floor(loc.z)}
§6Direction: §f${direction}
§6Dimension: §f${player.dimension.id}
    `;
    player.sendMessage(coordText);
}

function showPlayerList(player) {
    const players = tracker.getAllPlayers();
    let playerList = `§l§5Players Online (${players.length})§r\n`;
    
    players.forEach((p, index) => {
        playerList += `${index + 1}. §a${p.name}§r - Health: §c${p.health.toFixed(1)}§r\n`;
    });
    
    player.sendMessage(playerList);
}

function showStatus(player) {
    const health = player.getComponent("minecraft:health");
    const statusText = `
§l§5Player Status§r
§6Name: §f${player.name}
§6Health: §c${health.currentValue}§r/§c${health.maxValue}§r
§6Hunger: §6${player.hunger}§r/§620§r
§6XP Level: §b${player.level}§r
    `;
    player.sendMessage(statusText);
}

function showBiomeInfo(player) {
    // Note: Biome detection requires querying the world
    const loc = player.location;
    const biomeText = `
§l§5Biome Info§r
§6Location: §f${Math.floor(loc.x)}, ${Math.floor(loc.y)}, ${Math.floor(loc.z)}§r
§6Biome detection requires Script API updates§r
    `;
    player.sendMessage(biomeText);
}

function getDirection(yaw) {
    const directions = ["N", "NE", "E", "SE", "S", "SW", "W", "NW"];
    const index = Math.round(((yaw % 360) + 360) / 360 * 8) % 8;
    return directions[index];
}

// Periodic tick for updates
system.runInterval(() => {
    const players = world.getAllPlayers();
    players.forEach(player => {
        tracker.updatePlayer(player);
    });
}, 20); // Every second

console.warn(`${ROXY_PREFIX}Script loaded successfully!`);
