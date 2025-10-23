SUMMARY = "Audioroute for AudioReach"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/${PN}-${PV}/LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCREV = "16d37f2ff604c0c5e21eb535cf7c6c9c58c26caf"
PV = "0.0+git"
SRC_URI = "git://github.com/AudioReach/audioreach-audio-utils.git;protocol=https;branch=main"

S = "${UNPACKDIR}/${PN}-${PV}/audio-route"

inherit autotools pkgconfig

DEPENDS = "glib-2.0 tinyalsa expat"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
