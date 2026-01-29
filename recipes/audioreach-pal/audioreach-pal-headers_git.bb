inherit autotools pkgconfig

DESCRIPTION = "Common Pal headers installation"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/${PN}-${PV}/LICENSE;md5=51110a366f598bc0b8f8e59141a18efb"

SRCPROJECT = "git://github.com/AudioReach/audioreach-pal.git"
SRCBRANCH  = "qclinux1.0"
SRCREV     = "2dc3a2439d9e9b17d84c4ccb23b9cbf7fa12080b"
PV = "0.0+git"

SRC_URI = "${SRCPROJECT};protocol=https;branch=${SRCBRANCH};"
S = "${UNPACKDIR}/${PN}-${PV}/inc"

do_compile[noexec] = "1"

ALLOW_EMPTY:${PN} = "1"
