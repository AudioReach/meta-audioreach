SUMMARY = "VUI Interface Headers"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit externalsrc
EXTERNALSRC = "${TOPDIR}/workspace/sources/audioreach-pal/plugins/vui_interface/api/vui-interface"

inherit autotools pkgconfig

do_compile[noexec] = "1"

FILES:${PN}-dev = "${includedir}/* ${libdir}/pkgconfig/*"
FILES:${PN} = ""
ALLOW_EMPTY:${PN} = "1"