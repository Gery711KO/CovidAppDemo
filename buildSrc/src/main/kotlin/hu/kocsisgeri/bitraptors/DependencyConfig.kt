enum class DependencyConfig(val configName: String) {

    // include the dependency code, but doesn't provide code to the user module
    // user won't see the dependency
    Implementation("implementation"),

    // see the dependency code only, but the user module MUST have to add this dependency
    // user sees the dependency, but crashes if it doesn't include it in the app
    CompileOnly("compileOnly"),

    // include the dependency code and provide it to the user module
    // user will see the dependency
    Api("api"),

    Kapt("kapt"),

    Test("testImplementation"),

    AndroidTest("androidTestImplementation");
}