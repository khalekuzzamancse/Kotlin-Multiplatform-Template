import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import utils.libs

class ComposeMultiplatformPlugin : Plugin<Project> {
    /**use the name defined in /gradle/libs under plugin block*/
    private val composePluginAlias = "jetbrainsCompose"
    private val multiplatformPluginAlias = "kotlinMultiplatform"
    private val androidLibraryPluginAlias = "androidLibrary"
    override fun apply(project: Project) = with(project) {

        with(pluginManager) {
            //TODO:While using it need not apply(again) multiplatform, androidLibrary and JetBrainsCompose plugin
            apply(libs.findPlugin(multiplatformPluginAlias).get().get().pluginId)
            apply(libs.findPlugin(androidLibraryPluginAlias).get().get().pluginId)
            apply(libs.findPlugin(composePluginAlias).get().get().pluginId)


        }


        //TODO: Configuring KotlinMultiplatform
        extensions.configure<KotlinMultiplatformExtension> {
            jvmToolchain(17)
            androidTarget().apply {
                compilations.all {
                    kotlinOptions {
                        jvmTarget = "17"
                    }
                }
            }
            jvm("desktop"){
                jvmToolchain(17)
            }

            //    iosArm64()
            //    iosX64()
            //    iosSimulatorArm64()

            applyDefaultHierarchyTemplate()
            val jetBrainCompose = extensions.getByType<ComposeExtension>()
            sourceSets.apply {
                this.commonMain {
                    dependencies {
                        //Need not to implement these dependency again in the applied module
                        implementation(jetBrainCompose.dependencies.runtime)
                        implementation(jetBrainCompose.dependencies.foundation)
                        implementation(jetBrainCompose.dependencies.ui)
                        implementation(jetBrainCompose.dependencies.material3)
                        implementation(jetBrainCompose.dependencies.materialIconsExtended)
                        implementation(jetBrainCompose.dependencies.animation)
                        implementation(jetBrainCompose.dependencies.animationGraphics)
                        implementation(jetBrainCompose.dependencies.components.resources)   //for resources access
                    }
                }

                this.androidMain {
                    dependencies {

                    }
                }

                commonTest.dependencies {

                }
            }

            ///to use expect and actual keywords
            compilerOptions {
                // Common compiler options applied to all Kotlin source sets
                freeCompilerArgs.add("-Xmulti-platform")
            }


        }
        //TODO:Configuring Android, this the `android { }` block
        //TODO:While use it just define the `namespace` only in the `android block`
        extensions.configure<LibraryExtension> {
            compileSdk = 34
            defaultConfig {
                minSdk = 24
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
//                kotlinOptions { //Can not define here
//                    jvmTarget = "1.8"
//                }
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = "1.5.13"
            }
        }


    }
}