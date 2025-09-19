
- For JVM Desktop add the configure as:
  - `./gradlew applications:desktop:run`
    - on mac os use `/` and windows use `\`
  - You may add it as gradle configuration as: `applications:desktop:run`
  - 

# iOS setup
For some predefined gradle configuration, keep the xcode ios in the root directory
named with iosApp. renaming or moving to it another directory without any preconfiguration will
cause failed to run the app. that is because the scheme or configure use the KMP.app file which is present in the 
iosApp/iosApp/Products

Step 01: Open the iOS XCode project -> Select target-> Build Phases-> Compile Kotlin Framework:
paste the line following script:
```bash
if [ "YES" = "$OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED" ]; then
  echo "Skipping Gradle build task invocation due to OVERRIDE_KOTLIN_BUILD_IDE_SUPPORTED environment variable set to \"YES\""
  exit 0
fi
cd "$SRCROOT/.."

```
Step 02: 
Make sure you have the iOSMain src set otherwise the build/bin directory will not create  bin directory will contain 
the header and other binary that will used by the XCode project as framework dependency
Step 04:
run the task from XCode Environment : ./gradlew :applications:ios:embedAndSignAppleFrameworkForXcode. Since XCode inject some
environmental variable so running via terminal or android studio may not work

then run via XCode or create a new configuration on android studio as:
 Create configuration->XCode Application
