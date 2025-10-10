SUMMARY = "AudioReach Engine"
HOMEPAGE = "https://github.com/Audioreach/audioreach-engine"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b92f4957907c1bfc5cf7bb5a7ab8cefb"

SRCREV = "8ab1fa1895499604b761efb19f61cbed31fedb49"
PV = "0.0+git"
SRC_URI = "git://github.com/Audioreach/audioreach-engine.git;protocol=https;branch=master"
S = "${WORKDIR}/git"

#https://stackoverflow.com/questions/61473077/didnt-pass-ldflags-ldflags
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile[progress] = "percent"

EXTRA_OECMAKE += "-DARCH=linux -DCONFIG=defconfig"

LDFLAGS:append = " -pthread -lar-gpr -ltinyalsa"

inherit cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"

DEPENDS = "glib-2.0 audioreach-graphservices tinyalsa"

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
INSANE_SKIP:${PN} = "dev-so"

FILES:${PN} += "${libdir}/*${SOLIBS}"
