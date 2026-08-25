SUMMARY = "audio listen"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = "capiv2-api-headers"

inherit externalsrc
EXTERNALSRC = "${TOPDIR}/workspace/sources/audio-algos/audio-listen"

inherit autotools pkgconfig
