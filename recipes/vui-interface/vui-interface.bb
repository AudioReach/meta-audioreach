SUMMARY = "vui-interface"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS = "audioreach-pal-headers audioreach-conf vui-interface-header audioreach-graphservices audio-systems audio-listen"

inherit externalsrc
EXTERNALSRC = "${TOPDIR}/workspace/sources/audioreach-pal/plugins/vui_interface"

inherit autotools pkgconfig

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"