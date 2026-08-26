# Contributing to ROXY CLIENT

Thank you for your interest in contributing to ROXY CLIENT! This document provides guidelines and instructions for contributing.

## Code of Conduct

- Be respectful and inclusive
- Provide constructive feedback
- Focus on code quality and user experience
- Report bugs responsibly

## Getting Started

### Prerequisites

- Android Studio (Latest version)
- Kotlin 1.9.10+
- Gradle 8.0+
- JDK 11+
- Git

### Development Setup

```bash
# Clone your fork
git clone https://github.com/YOUR-USERNAME/RoxyClient.git
cd RoxyClient

# Create development branch
git checkout -b develop
git checkout -b feature/your-feature-name

# Open in Android Studio
# File > Open > Select RoxyClient folder
```

## Contribution Types

### Bug Reports

Create an issue with:
- Clear description
- Steps to reproduce
- Expected vs actual behavior
- Device info (Android version, device model)
- Screenshots/logs if applicable

### Feature Requests

Open an issue describing:
- Feature description
- Use cases
- Proposed implementation (if any)
- Alternative solutions considered

### Code Contributions

1. **Fork** the repository
2. **Create** a feature branch
3. **Make** your changes following code standards
4. **Test** thoroughly
5. **Commit** with clear messages
6. **Push** to your fork
7. **Open** a Pull Request

## Coding Standards

### Kotlin Style Guide

```kotlin
// Use clear, descriptive names
private val clientState = MutableStateFlow(ClientState())

// Follow Google Kotlin style guide
// https://developer.android.com/kotlin/style-guide

// Use data classes for models
data class ClientState(
    val version: String = "1.0.0",
    val isConnected: Boolean = false
)

// Proper spacing and organization
class MyViewModel : ViewModel() {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()
    
    fun updateState() {
        // Implementation
    }
}
```

### Compose Guidelines

```kotlin
// Use @Composable consistently
@Composable
fun MyScreen() {
    // Use proper state management
    var count by remember { mutableStateOf(0) }
    
    Column {
        Text("Count: $count")
    }
}

// Extract reusable components
@Composable
fun MyButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text)
    }
}
```

## Pull Request Process

1. **Update** documentation if needed
2. **Add** tests for new functionality
3. **Ensure** all tests pass
4. **Fill** out PR template completely
5. **Link** related issues
6. **Request** review from maintainers
7. **Address** feedback promptly

## Testing

### Unit Tests

```bash
# Run all tests
./gradlew test

# Run specific test
./gradlew testDebugUnitTest --tests com.roxyclient.model.*
```

### Android Tests

```bash
# Run on device/emulator
./gradlew connectedAndroidTest
```

## Documentation

- Update README.md for user-facing changes
- Add code comments for complex logic
- Document API changes
- Update CHANGELOG.md

## Commit Messages

```
Type: Brief description (50 chars max)

Detailed explanation if needed (wrap at 72 chars)

- Bullet point 1
- Bullet point 2

Fixes #123
```

### Types

- `feat:` New feature
- `fix:` Bug fix
- `docs:` Documentation
- `style:` Code style
- `refactor:` Code refactoring
- `test:` Test additions
- `chore:` Build/dependency updates

## Review Process

All submissions require review. Maintainers will:

1. Review code quality
2. Check for test coverage
3. Verify documentation
4. Test functionality
5. Provide feedback

## Questions?

Open an issue labeled `question` or contact maintainers directly.

---

**Thank you for contributing to ROXY CLIENT!**
