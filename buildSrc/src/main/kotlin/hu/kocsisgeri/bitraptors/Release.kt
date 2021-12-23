object Release {
    // lazy jake wharton versioning
    private val previousVerionCode = 10001
    val versionMajor = 1
    val versionMinor = 0
    val versionPatch = 0
    val versionBuild = 0 // bump for dogfood builds, public betas, etc.

    val versionCode =
        previousVerionCode + versionMajor * 10000 + versionMinor * 1000 + versionPatch * 100 + versionBuild
    val versionName = "$versionMajor.$versionMinor.$versionPatch"
}