//import org.gradle.api.Project
//import org.gradle.kotlin.dsl.configure
//import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
//
//class DataModulePlugin : KotlinMultiplatformPlugin() {
//    override fun apply(project: Project) = with(project) {
//        super.apply(project)
//        pluginManager.apply {
//            //TODO:While using it need not apply(again) multiplatform, androidLibrary and JetBrainsCompose plugin
//            //and also applied to root gradle script
//            apply(libs.findPlugin("kotlinxSerialization").get().get().pluginId)
//        }
//
//        // Override the sourceSets
//        extensions.configure<KotlinMultiplatformExtension> {
//            sourceSets.apply {
//                this.commonMain {
//                    dependencies {
//                        //make sure "ktorClient" exits under version catalog bundle
//                        implementation(libs.findBundle("ktorClient").get())
//                        //make sure "kotlinx-coroutines-core" exits in version catalog libraries
//                        implementation(libs.findLibrary("kotlinx-coroutines-core").get().get())
//
//                    }
//                }
//                this.androidMain {
//                    dependencies {
//                        //TODO:make sure "ktor-client-okhttp" exits in version catalog libraries
//                        implementation(libs.findLibrary("ktor-client-okhttp").get().get())
//                    }
//                }
//                //For window OS or desktop main
//                this.jvmMain.apply {
//                    dependencies {
//                        //make sure "ktor-client-okhttp" exits in version catalog libraries
//                        implementation(libs.findLibrary("ktor-client-okhttp").get().get())
//                    }
//                }
//            }
//        }
//    }
//}
