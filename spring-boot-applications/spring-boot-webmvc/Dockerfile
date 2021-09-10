FROM adoptopenjdk/openjdk11
MAINTAINER ChengGang <gang.cheng@lanmudata.com>
ENV APP_NAME="spring-boot-webmvc"
ENV APP_MEMORY="256M"
ENV JAR_PATH=/opt/project/$APP_NAME
ENV JAVA_OPTS="-server -Xms$APP_MEMORY -Xmx$APP_MEMORY -XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+UseContainerSupport -XX:G1NewSizePercent=40 -XX:+ParallelRefProcEnabled -Xlog:gc=debug:file=/opt/logs/$APP_NAME/gc.log:time,uptime,pid,tid,level,tags:filecount=50,filesize=100M"
RUN mkdir -p /opt/project/$APP_NAME /opt/logs/$APP_NAME && chmod -R 755 /opt/
COPY target/$APP_NAME.jar /opt/project/$APP_NAME/
CMD java $JAVA_OPTS -Duser.timezone=Asia/Hong_Kong -jar $JAR_PATH/$APP_NAME.jar