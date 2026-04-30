inherit autotools pkgconfig

DESCRIPTION = "Common Pal headers installation"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/${PN}-${PV}/LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCPROJECT = "git://github.com/AudioReach/audioreach-pal.git"
SRCBRANCH  = "master"
SRCREV     = "4a13cc426171047b00de1ad8f76d058cba89c95a"
PV = "0.0+git"

SRC_URI = "${SRCPROJECT};protocol=https;branch=${SRCBRANCH};"
S = "${UNPACKDIR}/${PN}-${PV}/inc"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
