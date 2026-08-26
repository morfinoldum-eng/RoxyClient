# Kotlin
-keepclassmembers class kotlin.Metadata {
    public <methods>;
}
-keep class kotlin.** { *; }
-keep interface kotlin.** { *; }

# Compose
-keep class androidx.compose.** { *; }

# DataStore
-keep class androidx.datastore.** { *; }

# Media3
-keep class androidx.media3.** { *; }

# Keep view constructors
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
