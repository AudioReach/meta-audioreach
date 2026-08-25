SUMMARY = "VoiceUI Audio Systems"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = "sva-eai capiv2-api-headers vui-interface-header"

inherit externalsrc
EXTERNALSRC = "${TOPDIR}/workspace/sources/audio-algos/audio-systems"

inherit autotools pkgconfig


SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"