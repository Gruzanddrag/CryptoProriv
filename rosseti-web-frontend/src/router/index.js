import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Signupform from '../views/signInUp.vue'
import requestsList from '../views/requestsList.vue'
import myDesk from '../views/myDesk.vue'
import messegeList from '../views/messegeList.vue'
import Moderator from '../views/moderator.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/myDesk',
    name: 'myDesk',
    component: myDesk
  },
  {
    path: '/messegeList',
    name: 'messegeList',
    component: messegeList
  },
  {
    path: '/signInUp',
    name: 'Signupform',
    component: Signupform
  },
  {
    path: '/requestsList',
    name: 'requestsList',
    component: requestsList
  },
  {
    path: '/moderator',
    name: 'moderator',
    component: Moderator
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
