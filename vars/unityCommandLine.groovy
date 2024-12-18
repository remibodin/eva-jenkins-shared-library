def call() {
    def unityEditorPath = "\"$UNITY_EDITORS_FOLDER\\$UNITY_VERSION\\Editor\\Unity.exe\""
    def unityOptions = "-batchmode -quit -logFile -"
    def unityProjectPath = "-projectPath \"$WORKSPACE\""

    if (env.UNITY_ACCELERATOR_IP != null &&
        env.UNITY_CACHE_PREFIX != null) 
    {
        unityOptions += " -EnableCacheServer -cacheServerEndpoint \"$UNITY_ACCELERATOR_IP\" -cacheServerNamespacePrefix $UNITY_CACHE_PREFIX -cacheServerEnableDownload true -cacheServerEnableUpload true"
    }

    return "${unityEditorPath} ${unityOptions} ${unityProjectPath}"
}