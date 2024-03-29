import {createRouter, createWebHistory} from 'vue-router'
import Accueil from '../views/Accueil.vue'
import Article from "@/views/Article.vue"
import Solo from "@/views/Solo.vue"

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'accueil',
            component: Accueil
        },
        {
            path: '/articles/:id',
            name: 'articles',
            component: Article
        },
        {
            path: '/atelier/:id',
            name: 'solo',
            component: Solo
        },
        {
            path: '/admin',
            name: "Admin",
            component: () => import('../views/Admin.vue'),
        },
        {
            path: '/admin/atelier/create',
            name: "CreateAtelier",
            component: () => import('../views/CreateAtelier.vue'),
        },
        {
            path: '/admin/atelier',
            name: "ViewAtelier",
            component: () => import('../views/ViewAtelier.vue'),
        },
    ]
})

export default router
