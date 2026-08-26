# Changelog

All notable changes to ROXY CLIENT will be documented in this file.

## [1.0.0] - 2026-08-26

### Added

#### Android App
- Initial release of ROXY CLIENT Android app
- Dark theme UI with purple/blue color scheme
- Main menu with 7 category modules
- Combat module with target info and CPS counter
- Movement module with sprint and jump controls
- Visuals module with ESP and entity highlighting
- Player module with coordinate and status display
- World module with biome and entity tracking
- HUD module with configurable display elements
- Settings menu with customization options
- Jetpack Compose UI framework
- DataStore for persistent preferences
- Floating menu service
- Background music service

#### Minecraft Bedrock Add-on
- Behavior pack with Script API integration
- Resource pack with UI elements
- Command system with `/roxy` prefix
- Player tracking system
- Coordinate display command
- Player list command
- Status information command
- Biome detection command

#### Project
- Complete Gradle configuration
- Android manifest setup
- ProGuard rules for obfuscation
- Color and string resources
- Typography setup
- Documentation (README, CONTRIBUTING)
- GitHub configuration

### Features

**Combat**
- ⚔️ Target Information Display
- 🎯 Hitbox Visualization
- 📏 Attack Range Indicator
- 🖱️ CPS Counter

**Movement**
- 🏃 Sprint Control
- ↕️ Auto-Jump Testing
- 📊 Movement HUD
- ⚡ Speed Meter

**Visuals**
- 👁️ ESP System
- 🏷️ Entity Nametags
- 📍 Distance Counter
- ☀️ Fullbright Mode
- 📡 Tracer System

**Player**
- 📍 Coordinates Display
- 🧭 Direction Indicator
- 💓 Health Display
- 📡 Ping Meter

**World**
- 🌍 Biome Detection
- 🕐 Time Display
- 🦑 Entity Tracking
- 🌲 World Statistics

**HUD**
- ⚡ FPS Counter
- 🖱️ CPS Display
- 📍 Coordinates
- ⌨️ Keystroke Visualizer
- 📡 Ping Display
- ⚡ Speed Meter
- 🏷️ Custom Watermark

**Settings**
- 🎬 Animation Speed Control
- 📏 Menu Size Adjustment
- 🎮 Button Position Control
- 🎨 Theme Customization
- 🔊 Audio Volume Control
- 🎵 Background Music Toggle
- ⚙️ Reset to Defaults

### Technical Details

- **Kotlin**: 1.9.10
- **Compose**: Latest
- **Android SDK**: 34 (Target), 26 (Minimum)
- **Java**: 11
- **Gradle**: 8.0+

### Performance

- Optimized render pipeline
- Minimal memory footprint
- Efficient state management
- ProGuard code obfuscation

### Compatibility

- Android 8.0+ (API 26+)
- Minecraft Bedrock 1.22.0+
- ARM64 and x86_64 architecture support

### Known Limitations

- Biome detection requires Script API updates
- Floating menu requires overlay permission
- Music requires audio resource
- Some features dependent on Minecraft version

### Future Roadmap

- [ ] PvP statistics tracking
- [ ] Server integration
- [ ] Custom macro system
- [ ] Advanced radar system
- [ ] In-game overlay optimization
- [ ] Plugin system
- [ ] Cloud settings sync
- [ ] Multi-language support
- [ ] Premium features
- [ ] Performance improvements

---

**ROXY CLIENT v1.0.0**

*Professional Minecraft Bedrock Client*
