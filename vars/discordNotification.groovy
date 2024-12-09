def call(String webhookURL, String imageURL) {

    def description = ""
    description += "**Id**: #" + currentBuild.id + "\n"
    description += "**Branch**: " + env.PLASTICSCM_BRANCH + "\n"
    description += "**Builder**: " + env.NODE_NAME + "\n"
    description += "**Time**: " + currentBuild.durationString + "\n"
    
    discordSend customUsername:"CI", 
        customAvatarUrl:"https://img.freepik.com/premium-photo/cute-smiling-robot_553012-14121.jpg", 
        title: currentBuild.projectName, 
        result: currentBuild.currentResult, 
        description: description,
        link: currentBuild.absoluteUrl, 
        image: imageURL,
        webhookURL:webhookURL
}