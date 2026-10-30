DESCRIPTION = "AudioReach Platform Adaptation Layer"
SECTION = "multimedia"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCPROJECT = "git://github.com/AudioReach/audioreach-pal.git"
SRCBRANCH  = "master"

SRCREV = "fa3105cfbcf86d5064b2bf1ab429fa419b2ba5a5"
PV = "0.0+git"
SRC_URI  = "${SRCPROJECT};protocol=https;branch=${SRCBRANCH}"

inherit autotools pkgconfig systemd

DEPENDS = "tinyalsa tinycompress audioreach-graphmgr audioreach-graphservices audioreach-conf audioreach-audio-utils"
PROVIDES += "audioreach-pal-headers"

EXTRA_OECONF += " --with-glib --with-syslog"

PACKAGES =+ "${PN}-headers ${PN}-vui-intf-headers"

FILES:${PN}-headers = " \
    ${includedir}/pal \
    ${libdir}/pkgconfig/pal-headers.pc \
"

FILES:${PN}-vui-intf-headers = " \
    ${includedir}/vuiInterfaceHeader \
    ${libdir}/pkgconfig/vui-intf-header.pc \
"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
