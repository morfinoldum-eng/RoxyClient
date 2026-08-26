# ROXY CLIENT

**Professional Minecraft Bedrock Client for Android**

![Version](https://img.shields.io/badge/version-1.0.0-blue.svg)
![Bedrock](https://img.shields.io/badge/bedrock-1.22.0%2B-brightgreen.svg)
![Android](https://img.shields.io/badge/android-API%2026%2B-orange.svg)
![License](https://img.shields.io/badge/license-MIT-green.svg)

## 🎮 Overview

ROXY CLIENT is a feature-rich Android companion app for Minecraft Bedrock Edition. It provides an intuitive overlay interface with professional client modifications, HUD elements, and server utilities.

### ✨ Key Features

#### 🔴 Combat Module
- Target Information Display
- Hitbox Visualization
- Attack Range Indicator
- CPS (Clicks Per Second) Counter
- Combat Statistics

#### 🏃 Movement Module
- Sprint Control
- Auto-Jump Testing
- Movement HUD Display
- Speed Meter
- Direction Indicator

#### 👀 Visuals Module
- ESP System (Entity Highlighting)
- Entity Nametags Display
- Distance Counter
- Fullbright Mode
- Tracer System
- Coordinate HUD

#### 🎮 Player Module
- Real-time Coordinates
- Direction/Rotation Display
- Dimension Tracking
- Network Ping Display
- Player Health/Status

#### 🌍 World Module
- World Coordinates
- Biome Detection
- Time Display
- Nearby Entity Tracking
- World Statistics

#### 📊 HUD Module
- FPS Counter
- CPS Display
- Coordinate Display
- Keystroke Visualizer
- Ping Meter
- Speed Display
- Custom Watermark

#### ⚙️ Settings
- Menu Animation Speed Control
- Menu Size Adjustment
- Floating Button Positioning
- Theme Customization
- Audio Volume Control
- Background Music Toggle
- Reset to Defaults

## 📋 Requirements

- **Android**: API Level 26 (Android 8.0) or higher
- **Minecraft**: Bedrock Edition 1.22.0+
- **RAM**: Minimum 2GB recommended
- **Storage**: ~100MB for installation

## 🚀 Installation

### From Source

```bash
# Clone repository
git clone https://github.com/morfinoldum-eng/RoxyClient.git
cd RoxyClient

# Build with Gradle
./gradlew build

# Install APK
./gradlew installDebug
```

### Minecraft Add-on Installation

1. Copy `minecraft/behavior_pack` to your Minecraft worlds folder
2. Copy `minecraft/resource_pack` to your Minecraft resource packs
3. Enable both packs in world settings
4. Use `/roxy help` command in-game

## 📱 App Architecture

### Technology Stack

- **Language**: Kotlin 1.9.10
- **UI Framework**: Jetpack Compose
- **State Management**: MutableStateFlow, ViewModel
- **Data Storage**: DataStore Preferences
- **Build System**: Gradle KTS
- **Min SDK**: 26
- **Target SDK**: 34

### Project Structure

```
RoxyClient/
├── android/
│   ├── app/
│   │   ├── src/
│   │   │   ├── main/
│   │   │   │   ├── java/com/roxyclient/
│   │   │   │   │   ├── MainActivity.kt
│   │   │   │   │   ├── model/
│   │   │   │   │   ├── viewmodel/
│   │   │   │   │   ├── repository/
│   │   │   │   │   ├── service/
│   │   │   │   │   ├── ui/
│   │   │   │   │   │   ├── theme/
│   │   │   │   │   │   ├── components/
│   │   │   │   │   │   └── screens/
│   │   │   │   │   └── utils/
│   │   │   │   ├── res/
│   │   │   │   │   ├── values/
│   │   │   │   │   │   ├── strings.xml
│   │   │   │   │   │   └── colors.xml
│   │   │   │   │   └── AndroidManifest.xml
│   │   ├── build.gradle.kts
│   │   └── proguard-rules.pro
│   ├── build.gradle.kts
│   └── settings.gradle.kts
├── minecraft/
│   ├── behavior_pack/
│   │   ├── manifest.json
│   │   └── scripts/
│   │       └── main.js
│   └── resource_pack/
│       ├── manifest.json
│       └── roxy_ui.json
├── docs/
├── .github/
├── README.md
└── LICENSE
```

## 📖 Usage

### Android App

1. Launch ROXY CLIENT from your app drawer
2. Navigate through menu categories using the main interface
3. Toggle features on/off from category screens
4. Adjust settings in the Settings menu
5. Customize HUD elements and appearance

### Minecraft Commands

```
/roxy help          - Show available commands
/roxy coords        - Display current coordinates
/roxy players       - Show online players
/roxy status        - Display player status
/roxy biome         - Show current biome info
```

## 🎨 Customization

### Theme Colors

Edit `android/app/src/main/res/values/colors.xml`:

```xml
<color name="primary_purple">#7C3AED</color>
<color name="primary_blue">#3B82F6</color>
<color name="accent_cyan">#06B6D4</color>
```

### HUD Elements

Configure in `minecraft/resource_pack/roxy_ui.json`:

```json
{
  "fps_counter": {
    "enabled": true,
    "position": [10, 10],
    "scale": 1.0
  }
}
```

## 🐛 Known Issues

- Biome detection requires Minecraft Script API updates
- Floating menu requires OVERLAY permission on some devices
- Music playback requires audio file in resources

## 🔄 Development

### Building

```bash
# Debug build
./gradlew buildDebug

# Release build
./gradlew buildRelease

# Run tests
./gradlew test
```

### Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit changes (`git commit -m 'Add amazing feature'`)
4. Push to branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## ⚖️ Disclaimer

This client is designed for legitimate testing and gameplay enhancement purposes. Users are responsible for ensuring compliance with Minecraft's Terms of Service and applicable game rules.

## 👨‍💻 Author

**morfinoldum-eng**
- GitHub: [@morfinoldum-eng](https://github.com/morfinoldum-eng)
- Email: morfinoldum@gmail.com

## 🙏 Acknowledgments

- Minecraft Bedrock Edition Community
- Jetpack Compose Team
- Android Development Community

## 📞 Support

For issues, questions, or feature requests, please open an [issue](https://github.com/morfinoldum-eng/RoxyClient/issues) on GitHub.

---

**ROXY CLIENT v1.0.0** - Professional Minecraft Bedrock Client

*Last Updated: August 26, 2026*
