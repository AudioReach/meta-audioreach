SUMMARY = "Pipewire pal plugins"
DESCRIPTION = "Pipewire plugin for AudioReach to enable PAL card integration and audio routing"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=91f36d19ef812a054b22d918288de2b5"

SRCREV = "09131e1d034523ce18b53309e44e83a8ec85ca7a"
PV = "0.0+git"
SRC_URI = "git://github.com/AudioReach/audioreach-pipewire-plugin.git;protocol=https;branch=master"

inherit autotools pkgconfig

DEPENDS = "audioreach-graphmgr pipewire audioreach-pal audioreach-pal-headers"

FILES:${PN} += "${libdir}/pipewire-0.3/*.so"
FILES:${PN} += "${datadir}/pipewire/pipewire.conf.d/pw-pal-plugin.conf"
FILES:${PN} += "${datadir}/wireplumber/wireplumber.conf.d/60-disable-alsa.conf"
FILES:${PN} += "${datadir}/wireplumber/wireplumber.conf.d/90-device-detection.conf"
FILES:${PN} += "${datadir}/wireplumber/wireplumber/scripts/90-device-detection.lua"
FILES:${PN} += "${datadir}/pipewire/pipewire.conf.d/deep-buffer-combine-stream.conf"
FILES:${PN} += "${datadir}/pipewire/pipewire.conf.d/low-latency-combine-stream.conf"
