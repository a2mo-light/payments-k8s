
java -javaagent:/home/ganesh/IdeaProjects/log-with-elk/elastic-apm-agent-0.7.0.jar\
     -Delastic.apm.service_name=elk-log-demo \
     -Delastic.apm.server_url=http://localhost:8200 \
     -Delastic.apm.application_packages=io.a2mo.light.demo \
     -jar ./build/libs/log-demo-1.0-SNAPSHOT.jar