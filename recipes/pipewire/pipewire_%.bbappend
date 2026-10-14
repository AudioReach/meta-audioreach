FILESEXTRAPATHS:prepend := "${THISDIR}/pipewire:"

SRC_URI += " \
    file://0001-pipewire-pulse-add-compress-offload-forwarding.patch \
    file://pal-compress-offload-sink.conf \
"

CONFFILES:${PN}-pulse += "${datadir}/pipewire/pipewire-pulse.conf.d/pal-compress-offload-sink.conf"

FILES:${PN}-pulse += " \
    ${datadir}/pipewire/pipewire-pulse.conf.d/pal-compress-offload-sink.conf \
"

do_install:append() {
    install -d ${D}${datadir}/pipewire/pipewire-pulse.conf.d
    install -m 0644 ${UNPACKDIR}/pal-compress-offload-sink.conf \
        ${D}${datadir}/pipewire/pipewire-pulse.conf.d/pal-compress-offload-sink.conf
}
