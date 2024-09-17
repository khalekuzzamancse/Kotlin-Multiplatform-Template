
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.compose.ComposeExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class ComposeMultiplatformPlugin : KotlinMultiplatformPlugin() {
    /**use the name defined in /gradle/libs under plugin block*/
    private val composePluginAlias = "jetbrainsCompose"
    private val multiplatformPluginAlias = "kotlinMultiplatform"
    private val androidLibraryPluginAlias = "androidLibrary"

    override fun apply(project: Project) = with(project) {
        super.apply(project)

        with(pluginManager) {
            //TODO:While using it need not apply(again) multiplatform, androidLibrary and JetBrainsCompose plugin
            apply(libs.findPlugin(multiplatformPluginAlias).get().get().pluginId)
            apply(libs.findPlugin(androidLibraryPluginAlias).get().get().pluginId)
            apply(libs.findPlugin(composePluginAlias).get().get().pluginId)
        }


        //TODO: Configuring KotlinMultiplatform
        extensions.configure<KotlinMultiplatformExtension> {
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
                        //make sure "kotlinx-coroutines-core" exits in version catalog libraries
                        implementation(libs.findLibrary("kotlinx-coroutines-core").get().get())
                        //make sure "windowSize" exits in version catalog libraries
                        implementation(libs.findLibrary("windowSize").get().get())
                    }
                }

                this.androidMain {
                    dependencies {

                    }
                }

                commonTest.dependencies {

                }
            }

        }
        //TODO:Configuring Android, this the `android { }` block
        //TODO:While use it just define the `namespace` only in the `android block`
        extensions.configure<LibraryExtension> {
//                kotlinOptions { //Can not define here
//                    jvmTarget = "1.8"
//                }
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = Constants.KOTLIN_COMPILER_EXTENSION_VERSION
            }
        }


    }


}
