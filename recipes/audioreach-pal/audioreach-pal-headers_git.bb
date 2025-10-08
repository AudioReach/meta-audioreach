inherit autotools pkgconfig

DESCRIPTION = "Common Pal headers installation"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/${PN}-${PV}/LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCPROJECT = "git://github.com/AudioReach/audioreach-pal.git"
SRCBRANCH  = "qclinux1.0"
SRCREV     = "2f6501d770f585aa7dbdfb95606a95af6782806a"
PV = "0.0+git"

SRC_URI = "${SRCPROJECT};protocol=https;branch=${SRCBRANCH};"
S = "${UNPACKDIR}/${PN}-${PV}/inc"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
