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
      children: [ {
          path: 'users',
          component: () => import('./components/UserList.vue')
        } , {
          path: 'certs',
          component: () => import('./components/CertList.vue')
        }
      ],
      component: () => import('./components/Admin.vue')
    }
  ]
});

export default router;