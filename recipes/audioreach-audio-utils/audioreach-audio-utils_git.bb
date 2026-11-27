SUMMARY = "Audioroute for AudioReach"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/${PN}-${PV}/LICENSE;md5=ef516c5438f1b599326a5e207572f477"

SRCREV = "4fe616c713b1f30eb60ccd28fb71c5134f62a653"
PV = "0.0+git"
SRC_URI = "git://github.com/AudioReach/audioreach-audio-utils.git;protocol=https;branch=main"

S = "${UNPACKDIR}/${PN}-${PV}/audio-route"

inherit autotools pkgconfig

DEPENDS = "glib-2.0 tinyalsa expat"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
RDEPENDS:${PN} += "tinyalsa expat"
