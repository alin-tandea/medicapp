import { MedicappNg2Page } from './app.po';

describe('medicapp-ng2 App', () => {
  let page: MedicappNg2Page;

  beforeEach(() => {
    page = new MedicappNg2Page();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
