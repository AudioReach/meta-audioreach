DESCRIPTION = "AudioReach Platform Adaptation Layer"
SECTION = "multimedia"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCPROJECT = "git://github.com/AudioReach/audioreach-pal.git"
SRCBRANCH  = "qclinux1.0"

SRCREV = "9c39264e6fa28152e9915687f91dea5a974adce2"
PV = "0.0+git"
SRC_URI  = "${SRCPROJECT};protocol=https;branch=${SRCBRANCH}"

inherit autotools pkgconfig systemd

DEPENDS = "tinyalsa tinycompress audioreach-graphmgr audioreach-graphservices audioreach-conf audioreach-audio-utils audioreach-pal-headers"

EXTRA_OECONF += " --with-glib --with-syslog"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"
