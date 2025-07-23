def call(ip,creds,user) {
  sshagent([creds]) {
    sh "scp -o StrictHostKeyChecking=no target/*.war ${user}@${ip}:/opt/apache10/webapps"
    sh "ssh ${user}@${ip} /opt/apache10/bin/shutdown.sh"
    sh "ssh ${user}@${ip} /opt/apache10/bin/startup.sh"
  }              
}
