SUMMARY = "AudioReach Graph Service"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6921cdd00790cae6b02ce61e60ab9e55"

SRCREV = "13ea91d2d9e08a34aaceac950c685b3c24e2f753"
PV = "0.0+git"
SRC_URI = "git://git@github.com/Audioreach/audioreach-graphservices.git;protocol=https;branch=master"

DEPENDS = "glib-2.0"
EXTRA_OECONF += "--with-syslog --with-glib --without-cutils --with-dummy_diag"
CFLAGS += "-Wno-int-conversion"

SOLIBS = ".so"
FILES_SOLIBSDEV = ""

PACKAGECONFIG[qcom] = "--with-qcom, --without-qcom, audioreach-kernel"
PACKAGECONFIG[are_on_apps] = "--with-are-on-apps, --without-are-on-apps"

inherit autotools pkgconfig
RRECOMMENDS:${PN} = " \
   kernel-module-audio-pkt \
   kernel-module-spf-core \
"
