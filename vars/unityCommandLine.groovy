def call() {
    def unityEditorPath = "$UNITY_EDITORS_FOLDER/$UNITY_VERSION/Editor/Unity.exe"
    def unityOptions = "-batchmode -quit -logFile -"
    def unityProject = "-projectPath \"$WORKSPACE\""

    return "${unityEditorPath} ${unityOptions} ${unityProject}"
}