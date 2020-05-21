import Vue from 'vue';
import Vuetify from 'vuetify/lib';

import 'material-design-icons-iconfont/dist/material-design-icons.css'
import 'vazir-font/dist/font-face.css'
import '../style/styles.sass'

Vue.use(Vuetify);

export default new Vuetify({
    iconfont: 'md',
    rtl: 'true'
});
