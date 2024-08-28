import { mount } from '@vue/test-utils'
import { describe, it, expect } from 'vitest'
import ToolTipComponent from '@/components/ToolTipComponent.vue'

describe('Test ToolTip', async () => {
  it('Test show on hover', async () => {
    document.body.innerHTML = `
    <div>
      <h1>Non Vue app</h1>
      <div id="app"></div>
    </div>`

    const mainText = 'Hello World!'
    const toolTipText = 'This is a tooltip!'
    const toolTip = mount(ToolTipComponent, {
      slots: {
        default: mainText,
        tooltip: toolTipText
      },
      attachTo: document.getElementById('app') as Element
    })

    expect(toolTip.find('div.pointer-events-auto').isVisible()).toBe(true)
    expect(toolTip.find('span.absolute').classList).toBeFalsy()
  })
})
