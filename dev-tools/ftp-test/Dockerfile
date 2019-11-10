FROM alpine:3

RUN apk add vsftpd ncftp

EXPOSE 2020-2021
EXPOSE 65500-65515

RUN mkdir /var/ftp
WORKDIR /var/ftp

RUN echo "hello, world">test.txt

COPY loader.sh /usr/sbin/

RUN chmod +x /usr/sbin/loader.sh && /usr/sbin/loader.sh

COPY vsftpd.conf /etc/vsftpd/

RUN chown root.root /etc/vsftpd/vsftpd.conf \
    && mkdir -p /var/run/vsftpd/empty \
    && touch /var/log/vsftpd.log

CMD ["/usr/sbin/vsftpd", "/etc/vsftpd/vsftpd.conf"]

# Build: docker build -t forecast-ftp-test .
# Run: docker run -d --name ftp-test -p 2020-2021:2020-2021 -p 65500-65515:65500-65515 forecast-ftp-test
# Check the logs: docker exec ftp-test tail -f /var/log/vsftpd.log
