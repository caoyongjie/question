import Vue from 'vue'
import Router from 'vue-router'
import index from '@/page/index'
import content from '@/page/content'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      component: index
    },
    {
      path: '/content/:id',
      component: content
    }
  ]
})
