import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'

import './plugins/element.js'
import 'element-ui/lib/theme-chalk/index.css';
import './assets/css/global.css'

// 端口号：http://116.62.159.13:8932
// axios.defaults.baseURL = 'http://116.62.159.13:8932'
axios.defaults.baseURL = 'http://116.62.15.76'
Vue.prototype.$http = axios
axios.defaults.withCredentials=true

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
