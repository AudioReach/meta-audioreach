DESCRIPTION = "AudioReach Platform Adaptation Layer"
SECTION = "multimedia"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCPROJECT = "git://github.com/AudioReach/audioreach-pal.git"
SRCBRANCH  = "master"

SRCREV = "ce70815478a43d173d3fad90bbd4d3f092501950"
PV = "0.0+git"
SRC_URI  = "${SRCPROJECT};protocol=https;branch=${SRCBRANCH}"

inherit autotools pkgconfig systemd

DEPENDS = "tinyalsa tinycompress audioreach-graphmgr audioreach-graphservices audioreach-conf mm-audio-headers audioreach-audio-utils"
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
