def call(String buildsDirectoryPath, String nasPath, String archiveName) 
{
    def temporaryDirectory = "${WORKSPACE}\\.jenkinsTmp";
    def temporaryArchivePath = "${temporaryDirectory}\\${archiveName}.zip"
    def nasArchivePath = "${nasPath}\\${archiveName}.zip"

    // create local temp directory
    powershell "New-Item -ItemType Directory -Force -Path \"${temporaryDirectory}\" | Out-Null"

    // zip release in temp directory
    powershell "Compress-Archive -Path \"${buildsDirectoryPath}/*\" -DestinationPath \"${temporaryArchivePath}\""

    // move archive to final directory
    powershell "Move-Item -Path \"${temporaryArchivePath}\" -Destination \"${nasArchivePath}\""
}