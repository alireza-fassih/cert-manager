import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

let router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [{
      path: '/login',
      name: 'login',
      component: () => import('./components/Login.vue')
    }, {
      path: '/admin',
      name: 'admin',
      component: () => import('./components/Admin.vue')
    }
  ]
});

export default router;