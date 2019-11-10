#!/bin/sh

fcastFiles="IDV10753 IDQ11295 IDN11060 IDT16710 IDS10044 IDW14199 IDD10207"

for f in $fcastFiles ; do
    echo Loading ${f}
    ncftpget -C ftp://ftp.bom.gov.au/anon/gen/fwo/${f}.xml /var/ftp/${f}.xml
done
