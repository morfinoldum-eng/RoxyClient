package com.roxyclient.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.roxyclient.model.MenuItem
import com.roxyclient.ui.components.MenuItemButton
import com.roxyclient.ui.components.StatusIndicator

@Composable
fun MainMenuScreen() {
    var currentMenu by remember { mutableStateOf<MenuItem?>(null) }
    var isMenuOpen by remember { mutableStateOf(true) }
    var isConnected by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.background,
                        MaterialTheme.colorScheme.background
                    )
                )
            )
    ) {
        if (isMenuOpen) {
            AnimatedContent(
                targetState = currentMenu,
                label = "menu_transition",
                modifier = Modifier.fillMaxSize()
            ) { targetMenu ->
                if (targetMenu == null) {
                    MainMenu(
                        onMenuItemClick = { currentMenu = it },
                        isConnected = isConnected
                    )
                } else {
                    CategoryScreen(
                        menuItem = targetMenu,
                        onBackClick = { currentMenu = null }
                    )
                }
            }
        }
    }
}

@Composable
fun MainMenu(
    onMenuItemClick: (MenuItem) -> Unit,
    isConnected: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "🎮",
                    fontSize = 48.sp
                )
                Text(
                    text = "ROXY CLIENT",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = "Professional Minecraft Bedrock Client",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Status
        StatusIndicator(
            isConnected = isConnected,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Menu Items
        MenuItem.all().forEach { item ->
            AnimatedVisibility(
                visible = true,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {
                MenuItemButton(
                    title = item.title,
                    icon = item.icon,
                    onClick = { onMenuItemClick(item) },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Footer
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Version 1.0.0",
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Bedrock Latest (1.22.0+)",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun CategoryScreen(
    menuItem: MenuItem,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header with back button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surface)
                .clickable { onBackClick() }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "←",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = menuItem.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = menuItem.icon,
                fontSize = 24.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Category specific content
        when (menuItem) {
            is MenuItem.Combat -> CombatCategoryScreen()
            is MenuItem.Movement -> MovementCategoryScreen()
            is MenuItem.Visuals -> VisualsCategoryScreen()
            is MenuItem.Player -> PlayerCategoryScreen()
            is MenuItem.World -> WorldCategoryScreen()
            is MenuItem.HUD -> HUDCategoryScreen()
            is MenuItem.Settings -> SettingsCategoryScreen()
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun CombatCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "⚔️ Combat Features\n\nTarget Info\nHitbox Visualization\nAttack Range\nCPS Counter",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun MovementCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "🏃 Movement Features\n\nSprint Control\nAuto-Jump Test\nMovement HUD\nSpeed Meter",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun VisualsCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "👁️ Visuals Features\n\nESP System\nEntity Nametags\nDistance Counter\nFullbright Mode\nTracer System\nCoordinates HUD",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PlayerCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "👤 Player Info\n\nCoordinates\nDirection\nDimension\nPing\nPlayer Status",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun WorldCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "🌍 World Info\n\nCoordinates\nBiome Detection\nTime Display\nNearby Entities\nWorld Stats",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun HUDCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "📊 HUD Elements\n\nFPS Counter\nCPS Counter\nCoordinates\nKeystrokes\nPing Meter\nSpeed Display\nDirection Indicator\nCustom Watermark",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun SettingsCategoryScreen() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Text(
            text = "⚙️ Settings\n\nMenu Animation\nMenu Size\nButton Position\nTheme Options\nAudio Controls\nReset to Default",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

import androidx.compose.foundation.clickable
