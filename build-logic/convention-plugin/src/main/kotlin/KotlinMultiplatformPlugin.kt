import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension


open class KotlinMultiplatformPlugin: Plugin<Project> {
    /**use the name defined in /gradle/libs under plugin block*/

    override fun apply(project: Project) = with(project) {

        with(pluginManager) {
            //TODO:While using it need not apply(again) multiplatform, androidLibrary plugin
            apply(Constants.KMP_PLUGIN_ID)
            apply(Constants.ANDROID_LIBRARY_PLUGIN_ID)
        }


        //TODO: Configuring KotlinMultiplatform
        extensions.configure<KotlinMultiplatformExtension> {
            jvmToolchain( Constants.JVM_TARGET.toInt())

            androidTarget().apply {
                compilations.all {
//                    kotlinOptions {
//                        jvmTarget = Constants.JVM_TARGET
//                    }
                }
            }
            //  TODO:Adding desktop window support
            jvm("desktop"){
              //  jvmToolchain( Constants.JVM_TARGET.toInt())
            }

            //    iosArm64()
            //    iosX64()
            //    iosSimulatorArm64()

            applyDefaultHierarchyTemplate()

            sourceSets.apply {
                this.commonMain {
                    dependencies {

                    }
                }

                this.androidMain {
                    dependencies {

                    }
                }

                commonTest.dependencies {

                }
            }

//            ///to use expect and actual keywords
//            compilerOptions {
//                // Common compiler options applied to all Kotlin source sets
//                freeCompilerArgs.add("-Xmulti-platform")
//            }


        }
        //TODO:Configuring Android, this the `android { }` block
        //TODO:While use it just define the `namespace` only in the `android block`
        extensions.configure<LibraryExtension> {
            compileSdk = Constants.COMPILE_SDK
            defaultConfig {
                minSdk = Constants.MIN_SDK
            }

            buildTypes {
                release {
                    isMinifyEnabled = false
                }
            }
            compileOptions {
                sourceCompatibility = Constants.SOURCE_COMPATIBILITY
                targetCompatibility = Constants.TARGET_SOURCE_COMPATIBILITY
            }
//                kotlinOptions { //Can not define here
//                    jvmTarget = "1.8"
//                }
        }

    }



    protected  val Project.libs
        get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
}
