
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposePlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeMultiplatformPlugin : KotlinMultiplatformPlugin() {
    override fun apply(project: Project) = with(project) {
        super.apply(project)

        with(pluginManager) {
            //TODO:While using it need not apply(again) multiplatform, androidLibrary and JetBrainsCompose plugin
            apply(Constants.KMP_PLUGIN_ID)
            apply(Constants.ANDROID_LIBRARY_PLUGIN_ID)
            apply(Constants.COMPOSE_COMPILER_PLUGIN_ID)
            apply(Constants.CMP_PLUGIN_ID)
        }


        //TODO: Configuring KotlinMultiplatform
        extensions.configure<KotlinMultiplatformExtension> {
            applyDefaultHierarchyTemplate()
        val cmpDependencies = extensions.getByType<ComposePlugin.Dependencies>()
            sourceSets.apply {
                this.commonMain {
                    dependencies {
                        //Need not to implement these dependency again in the applied module
                        implementation(cmpDependencies.runtime)
                        implementation(cmpDependencies.foundation)
                        implementation(cmpDependencies.ui)
                        implementation(cmpDependencies.material3)
                        implementation(cmpDependencies.materialIconsExtended)
                        implementation(cmpDependencies.animation)
                        implementation(cmpDependencies.animationGraphics)
                        implementation(cmpDependencies.components.uiToolingPreview)
                        implementation(cmpDependencies.components.resources)   //for resources access
                     //TODO:make sure "kotlinx-coroutines-core" exits in version catalog libraries
                        implementation(libs.findLibrary("kotlinx-coroutines-core").get().get())
                    }
                }

                this.androidMain {
                    dependencies {

                    }
                }
                this.jvmMain {
                    dependencies {
                        //TODO:make sure "kotlinx-coroutines-swing" exits in version catalog libraries
                      implementation(libs.findLibrary("kotlinx-coroutines-swing").get().get())
                    }

                }

                commonTest.dependencies {

                }
            }

        }
        //TODO:Configuring Android, this the `android { }` block
        //TODO:While use it just define the `namespace` only in the `android block`
        extensions.configure<LibraryExtension> {
            buildFeatures {
                compose = true
            }
            //     kotlinOptions { //Can not define here
//                    jvmTarget = "1.8"
//                }
//            composeOptions {
//                kotlinCompilerExtensionVersion = Constants.KOTLIN_COMPILER_EXTENSION_VERSION
//            }
        }


    }


}
