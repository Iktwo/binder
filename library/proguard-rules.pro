-keepattributes Signature

-keep public class com.iktwo.** { *; }

-dontwarn android.databinding.**
-keep class android.databinding.** { *; }

-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-keep class kotlin.jvm { *; }

-dontwarn kotlin.**

-keepclassmembers class **$WhenMappings {
    <fields>;
}