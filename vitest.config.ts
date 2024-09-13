import {defineConfig} from 'vitest/config'

export default defineConfig({
  test: {
    deps: {
      moduleDirectories: ['node_modules'],
    },
    reporters: process.env.GITHUB_ACTIONS ? ['verbose', 'github-actions'] : ['verbose']
  },
})