FROM adoptopenjdk/openjdk13
LABEL maintainer="dylim@kcp.co.kr"

ENV JAVA_OPTS "-server \
  -Djava.awt.headless=true \
  -Xms256m \
  -Xmx256m \
  -Duser.timezone=GMT+09:00 "

WORKDIR ${APP_HOME}

COPY build/libs/*.jar app.jar
RUN gradle build -x test --parallel --continue > /dev/null 2>&1 || true

ENTRYPOINT java $JAVA_OPTS -jar app.jar

EXPOSE 8888