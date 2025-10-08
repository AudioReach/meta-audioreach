SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6921cdd00790cae6b02ce61e60ab9e55"

SRCREV = "810bd79e04d1b3e8d0a898fb649c07384f771b46"
PV = "0.0+git"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

DEPENDS = "glib-2.0"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils --with-dummy_diag"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom, audioreach-kernel"
PACKAGECONFIG[are_on_apps] = "--with-are-on-apps, --without-are-on-apps"

inherit autotools pkgconfig
RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core \
"
