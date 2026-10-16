# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# Keep data models and serialization classes
-keep class com.yourdomain.yourapp.models.** { *; }

# Keep libraries that use reflection (Example: Gson)
-keepattributes *Annotation*, Signature, InnerClasses, EnclosingMethod
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.** { *; }
-dontwarn com.google.gson.**

# If using Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keep class com.yourdomain.yourapp.network.** { *; }

# Keep native methods if using JNI/NDK
-keepclasseswithmembernames class * {
    native <methods>;
}