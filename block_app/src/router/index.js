import Vue from 'vue'
import VueRouter from 'vue-router'
const Login =()=> import('../components/Login.vue')
const Test =()=> import('../components/Test.vue')
// import login from '../components/Test.vue'

Vue.use(VueRouter)

  const routes = [
		{
			path:'/',
			redirect:'/login'
		},
		{
			path:'/login',
			component:Login
		},
		{
			path:'/test',
			component:Test
		}
]

const router = new VueRouter({
  routes
})

export default router
