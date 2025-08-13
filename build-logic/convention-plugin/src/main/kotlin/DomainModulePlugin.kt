//import org.gradle.api.Project
//import org.gradle.kotlin.dsl.configure
//import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
//
//class DomainModulePlugin : KotlinMultiplatformPlugin() {
//    override fun apply(project: Project) = with(project) {
//        super.apply(project)
//        pluginManager.apply {
//
//        }
//
//        // Override the sourceSets
//        extensions.configure<KotlinMultiplatformExtension> {
//            sourceSets.apply {
//                this.commonMain {
//                    dependencies {
//                        implementation(libs.findLibrary("kotlinx-coroutines-core").get().get())
//
//                    }
//                }
//                this.androidMain {
//                    dependencies {
//
//                    }
//                }
//                //For window OS or desktop main
//                this.jvmMain.apply {
//                    dependencies {
//
//                    }
//                }
//            }
//        }
//    }
//}
